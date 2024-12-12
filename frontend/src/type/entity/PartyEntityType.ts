import AdressEntityType from "./AdressEntityType.ts";

interface PartyEntityType{
    id: number;
    name: string;
    description: string;
    address:AdressEntityType;
    capacity?: number;
    organizer:{
        id:number,
        username:string,
    }
    participants?: {
        id?: number,
        username?: string,
    }[];
    partyType:{
        id?: number,
        name?: string,
        description?: string,
    }
    isPaid?: boolean;
    price?: number;
    published?: boolean;
    dateParty: string;
}

export default PartyEntityType;