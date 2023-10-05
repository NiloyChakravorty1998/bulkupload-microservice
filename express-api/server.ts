import express, { Request, Response } from "express";
import dotenv from 'dotenv'
import cors from 'cors'
import cookieParser from "cookie-parser";
import connectDB from "./config/db";
import cloakServiceRouter from "./routes/cloakRoutes";

dotenv.config();
const port: string = process.env.PORT || '3000';

connectDB();

const app = express();
app.use(cookieParser());
app.use(express.json());
app.use(express.urlencoded({ extended : true }))

app.use(cors({
    origin: `${process.env.ORIGIN_URI}`, // Update with your frontend's URL
    credentials: true, // Allow cookies to be included in the request
  }));

//POST FOR TOKENIZE / DETOKENIZE
app.use('/api/cloak', cloakServiceRouter);

app.listen(port,() => {
    console.log(`App started on port: ${port}`);
})