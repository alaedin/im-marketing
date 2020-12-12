import {Component, Inject, OnInit} from '@angular/core';
import {Client} from '../../../../../../core/im-marketing/model/client';
import {Person} from '../../../../../../core/im-marketing/model/person';
import {MAT_DIALOG_DATA, MatDialogRef, MatSelectChange, MatTableDataSource} from '@angular/material';
import {FormControl, Validators} from '@angular/forms';
import {AppointmentType} from '../../../../../../core/im-marketing/model/appointment-type';
import {AppointmentComponent} from '../../appointment/appointment.component';
import {Appointment} from '../../../../../../core/im-marketing/model/appointment';
import {AppointmentService} from '../../../../../../core/im-marketing/service/appointment.service';
import {PersonService} from '../../../../../../core/im-marketing/service/person.service';
import {ClientService} from '../../../../../../core/im-marketing/service/client.service';
import {AppointmentTypeService} from '../../../../../../core/im-marketing/service/appointment-type.service';

@Component({
	selector: 'kt-appointment-edit-general',
	templateUrl: './appointment-edit-general.component.html',
	styleUrls: ['./appointment-edit-general.component.scss']
})
export class AppointmentEditGeneralComponent implements OnInit {

	isNewClient;
	suggestions: boolean;
	selectedClient: number;
	selectedPerson;
	clients: Client [] = [];
	persons: Person [] = [];

	client: Client = new Client();
	person: Person = new Person();
	emailFormControl = new FormControl('', [
		Validators.required,
		Validators.email,
	]);
	minDate = new Date(1900, 0, 1);
	maxDate = new Date();
	appointmentTypes: AppointmentType[] = [];
	appointmentType = new AppointmentType();

	title;
	role;
	private appointments: Appointment[];
	private appointment = new Appointment();
	time;

	constructor(public dialogRef: MatDialogRef<AppointmentComponent>,
				private appointmentService: AppointmentService,
				private personService: PersonService,
				private clientService: ClientService,
				private appointmentTypeService: AppointmentTypeService,
				@Inject(MAT_DIALOG_DATA) public data: any) {

	}

	ngOnInit() {
		this.title = 'Rendez-vous';

		this.getAllPersons();
		this.getAllClients();
		this.getAllAppointmentType();
	}

	changeSelectedCommercial($event: MatSelectChange) {

	}

	changeSelectedClient($event: MatSelectChange) {

	}

	selectAppointmentType($event: Event) {

	}

	getAllPersons() {
		this.personService.getAll()
			.subscribe(
				data => {
					this.persons = data.body;
					console.log('persons');
					console.log(this.persons);
				},
				error => {
					console.log(error);
				}
			);
	}

	getAllClients() {
		this.clientService.getNotExistsInAppointment()
			.subscribe(
				data => {
					this.clients = data.body;
					console.log('clients ');
					console.log(this.clients);
				},
				error => {
					console.log(error);
				}
			);

	}

	getAllAppointmentType() {
		this.appointmentTypeService.getAll()
			.subscribe(
				data => {
					this.appointmentTypes = data.body;
					console.log('appointment type');
					console.log(this.appointmentTypes);
				},
				error => {
					console.log(error);
				}
			);

	}

	addNewClient() {
		this.isNewClient = this.isNewClient === true ? false : true;
	}


	createOrUpdateAppointment() {
		if (!this.isNewClient) {
			this.client.email = this.emailFormControl.value;
		}

		console.log('create appointment : ');
		console.log(JSON.stringify(this.appointment));
		if (this.data.id) {
			this.appointmentService.update(this.data.id, this.appointment)
				.subscribe(
					data => {
						console.log(this.data);
						// this.submitted = true;
					},
					error => {
						console.log(error);
					}
				);

		} else {
			console.log('**********************************');
			console.log(this.appointment);
			this.appointmentService.create(this.appointment)
				.subscribe(
					data => {
						console.log(this.data);
						// this.submitted = true;
					},
					error => {
						console.log(error);
					}
				);
		}

		this.closeDialog();
	}

	closeDialog(): void {
		this.dialogRef.close();
	}
}
