import { validateRequest } from '@eoet/common';
import express, { Request, Response } from 'express';
import { body } from 'express-validator';
import { Comment } from '../models/comment';

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

        res.status(201).send(comment);
    }
);

export { router as createCommentRouter };
