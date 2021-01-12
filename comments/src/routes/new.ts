import { validateRequest } from '@eoet/common';
import express, { Request, Response } from 'express';
import { body } from 'express-validator';
import { Comment } from '../models/comment';
import axios from 'axios';
import { Subjects } from '@eoet/common/build/events/subjects';

const router = express.Router();

router.post(
    '/api/comments',
    [
        body('content').not().isEmpty().withMessage('Content is required'),
        body('user').not().isEmpty().withMessage('User is required'),
        body('post').not().isEmpty().withMessage('Post is required')
    ],
    validateRequest,
    async (req: Request, res: Response) => {
        const { content, user, post } = req.body;

        const comment = Comment.build({
            content,
            userId: user,
            postId: post
        });

        await comment.save();

        // Publish an event comment:created
        try {
            await axios.post('http://events-srv:3000/api/events-bus', {
                subject: Subjects.CommentCreated,
                data: comment
            })            
        } catch (error) {
            console.log('🚀 ~ file: new.ts ~ line 36 ~ error', error);
        }

        res.status(201).send(comment);
    }
);

export { router as createCommentRouter };
