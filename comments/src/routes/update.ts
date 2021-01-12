import { NotFoundError, validateRequest } from '@eoet/common';
import express, { Request, Response } from 'express';
import { body } from 'express-validator';
import { Comment } from '../models/comment';

const router = express.Router();

router.put(
    '/api/comments/:id',
    [
        body('content').not().isEmpty().withMessage('Content is required'),
        body('user').not().isEmpty().withMessage('User is required'),
        body('post').not().isEmpty().withMessage('Post is required')
    ],
    validateRequest,
    async (req: Request, res: Response) => {
        const comment = await Comment.findById(req.params.id);
        if (!comment) {
            throw new NotFoundError();
        }
        const { content, user, post } = req.body;

        comment.set({
            content,
            userId: user,
            postId: post
        });
        await comment.save();

        res.send(comment);
    }
);

export { router as updateCommentRouter };

