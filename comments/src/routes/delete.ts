import { NotFoundError } from '@eoet/common';
import express, { Request, Response } from 'express';
import { Comment } from '../models/comment';

const router = express.Router();

router.delete(
    '/api/comments/:id',
    async (req: Request, res: Response) => {
        const { commentId } = req.body;
        const comment = await Comment.findById(commentId);
        if (!comment) {
            throw new NotFoundError();
        }

        await comment.remove();

        res.send({});
    }
);

export { router as deleteCommentRouter };

