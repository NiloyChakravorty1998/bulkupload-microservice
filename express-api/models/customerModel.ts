import mongoose from "mongoose";

const customerSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    customerId: {
        type: Number,
        required: true
    },
    idKey: {
        type: Number,
        required: true
    }
},{
    timestamps: true
})

const customerInfo = mongoose.model('customerInfo', customerSchema);
export default customerInfo;