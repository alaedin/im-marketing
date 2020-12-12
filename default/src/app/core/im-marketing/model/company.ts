import {Person} from './person';
import {Phone} from './phone';

export class Company {
	companyName: string;
	rib: string;
	iban: string;
	codeBic: string;
	description: string;
	person: Person[];
	phone: Phone;

	clear() {
		this.companyName = '';
		this.rib = '';
		this.iban = '';
		this.codeBic = '';
		this.description = '';
		this.person = [];
		this.phone = null;
	}
}
