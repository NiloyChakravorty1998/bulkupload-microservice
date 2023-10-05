import express from 'express'
import { detokenizeCustomerId, tokenizeCustomerId } from '../controller/cloakServiceController';

const cloakServiceRouter = express.Router();

cloakServiceRouter.post('/tokenize', tokenizeCustomerId);

cloakServiceRouter.post('/detokenize', detokenizeCustomerId);

export default cloakServiceRouter;