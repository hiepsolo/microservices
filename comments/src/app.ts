import express from 'express';
import 'express-async-errors';
import { json } from 'body-parser';
import cookieSession from 'cookie-session';

import { currentUser, errorHandler, NotFoundError } from '@eoet/common';
import { allCommentRouter } from './routes';
import { createCommentRouter } from './routes/new';
import { updateCommentRouter } from './routes/update';
import { deleteCommentRouter } from './routes/delete';

const app = express();
app.set('trust proxy', true);
app.use(
    cookieSession({
        signed: false,
        secure: process.env.NODE_ENV !== 'test',
    })
);
app.use(json());

app.use(currentUser);

app.use(createCommentRouter);
app.use(allCommentRouter);
app.use(updateCommentRouter);
app.use(deleteCommentRouter);

app.all('*', async (req, res) => {
    throw new NotFoundError();
});

app.use(errorHandler);

export { app };
