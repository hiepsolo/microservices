import { Subjects } from './subjects';

export interface CommentDeletedEvent {
    subject: Subjects.CommentDeleted;
    data: {
        commentId: string,
        content?: string
    };
}
