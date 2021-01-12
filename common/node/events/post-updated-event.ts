import { Subjects } from './subjects';

export interface PostUpdatedEvent {
    subject: Subjects.PostUpdated;
    data: {
        postId: string,
        title: string
    };
}
