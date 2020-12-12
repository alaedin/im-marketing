import {Client} from './client';
import {Person} from './person';
import {AppointmentType} from './appointment-type';

export class Appointment {
	id: number;
	appointmentDate: Date;
	prix: number;
	tax: number;
	person: Person = new Person();
	client: Client = new Client();
	appointmentType: AppointmentType = new AppointmentType();
}
