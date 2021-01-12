import { Subjects } from './subjects';

export interface UserUpdatedEvent {
    subject: Subjects.UserUpdated;
    data: {
        userId: string,
        name: string
    };
}
