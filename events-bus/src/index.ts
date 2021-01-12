import { app } from './app';

const port = 3000;

const start = async () => {
    app.listen(port, () => {
        console.log(`Listening on port: ${port}!!!!`);
    });
};

start();
