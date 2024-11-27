import AdressEntityType from "./AdressEntityType.ts";

interface PartyEntityType{
    id: number;
    name: string;
    description: string;
    address:AdressEntityType;
    capacity: number;
    isPaid: boolean;
    price: number;
    isPublished: boolean;
    dateParty: string;
}

export default PartyEntityType;