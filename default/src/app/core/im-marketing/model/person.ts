import {Role} from './role';
import {Company} from './company';
import {Phone} from './phone';

export class Person {
	id: number;
	firstName: string;
	lastName: string;
	birthdate: Date;
	address: string;
	role: Role;
	email: string;
	phone: Phone;
	company: Company;


}
