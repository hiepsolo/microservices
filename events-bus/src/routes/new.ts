import { validateRequest } from '@eoet/common';
import axios from 'axios';
import express, { Request, Response } from 'express';
import { body } from 'express-validator';

const router = express.Router();

router.post(
    '/api/events-bus',
    [
        body('subject').not().isEmpty().withMessage('Subject is required'),
        body('data').not().isEmpty().withMessage('Data is required')
    ],
    validateRequest,
    async (req: Request, res: Response) => {
        const { subject, data } = req.body;
        console.log('Listen in Event-bus', req.body);

        // Publish to listeners
        axios.post('http://comments-srv:3000/api/events', {
            subject: subject,
            data
        });

        res.status(201).send({});
    }
);

export { router as createEventRouter };

