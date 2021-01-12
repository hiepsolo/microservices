import { Subjects } from '@eoet/common/build/events/subjects';
import express, { Request, Response } from 'express';

const router = express.Router();

router.post('/api/events', async (req: Request, res: Response) => {
    console.log('Received Event', req.body);

    res.send({});
});

export { router as eventsListenerRouter };
