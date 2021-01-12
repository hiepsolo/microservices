import { Request, Response, NextFunction } from 'express';
import jwt from 'jsonwebtoken';
import cookie from 'cookie';

interface UserPayload {
  id: string;
  email: string;
}

declare global {
  namespace Express {
    interface Request {
      currentUser?: UserPayload;
    }
  }
}

export const currentUser = (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  if (!req.session?.jwt && !req.headers.cookie) {
    return next();
  }

  try {
    let jwtToken = '';
    if (req.session?.jwt) {
      jwtToken = req.session.jwt;
    } else {
      jwtToken = (cookie.parse(req.headers.cookie!))['jwt'];
    }

    const payload = jwt.verify(
      jwtToken,
      process.env.JWT_KEY!
    ) as UserPayload;
    req.currentUser = payload;
  } catch (err) {}

  next();
};
