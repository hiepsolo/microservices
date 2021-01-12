import { Subjects } from './subjects';

export interface PostDeletedEvent {
    subject: Subjects.PostDeleted;
    data: {
        postId: string
    };
}
