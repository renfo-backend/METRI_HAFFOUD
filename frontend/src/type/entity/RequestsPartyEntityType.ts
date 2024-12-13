import PartyEntityType from "./PartyEntityType.ts";
import USER_LOGIN from "../USER_LOGIN.ts";

interface RequestsPartyEntityType{
    id?:number
    party?:PartyEntityType
    users?:USER_LOGIN
    status?:string
}
export default RequestsPartyEntityType;