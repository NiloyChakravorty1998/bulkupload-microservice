import express, { Request, Response } from 'express'
import asyncHandler from '../middleware/asyncHandler'
import customerInfo from '../models/customerModel';

export const tokenizeCustomerId = asyncHandler(async(req:Request, res: Response) =>
{
    const name : String =req.body.name;
    const customerId : Number = req.body.customerId;
    const idKey : Number = Date.now();
    const customer = await customerInfo.findOne({customerId});

    if(customer)
    {
        res.status(200).json(
            {
                status: 200,
                message: 'Encryption successful',
                idKey: customer.idKey
            }
        )
    }
    else{
        const customerCreate = await customerInfo.create({name, customerId, idKey});
        res.status(200).json(
            {
                status: 200,
                message: 'Encryption successful',
                idKey: idKey
            }
        )
    }
});

export const detokenizeCustomerId = asyncHandler(async(req:Request, res: Response) =>
{
    const customerData : {name : String, idKey : Number} =req.body;
    const customer = await customerInfo.findOne({idKey : customerData.idKey});

    if(customer)
    {
        res.status(200).json(
            {
                status: 200,
                message: 'User found successful',
                customerId: customer.customerId
            }
        )
    }
    else{
        res.status(401);
        throw new Error('Invalid key');
    }
});