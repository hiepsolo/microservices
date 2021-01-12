import { Subjects } from './subjects';

export interface CommentUpdatedEvent {
    subject: Subjects.CommentUpdated;
    data: {
        commentId: string,
        content?: string
    };
}
