import {Phone} from './phone';

export class Client {

	id: number;
	firstName: string;
	lastName: string;
	birthdate: Date ;
	address: string;
	email: string;
	phone: Phone = new Phone();

}
