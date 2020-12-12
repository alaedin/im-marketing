import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {Client} from '../../../../../core/im-marketing/model/client';
import {HttpClient} from '@angular/common/http';
import {MAT_DIALOG_DATA, MatDialogRef, MatTableDataSource} from '@angular/material';
import {Person} from '../../../../../core/im-marketing/model/person';
import {Appointment} from '../../../../../core/im-marketing/model/appointment';
import {AppointmentService} from '../../../../../core/im-marketing/service/appointment.service';
import {AppointmentListComponent} from '../appointment-list/appointment-list.component';
import {ClientService} from '../../../../../core/im-marketing/service/client.service';
import {PersonService} from '../../../../../core/im-marketing/service/person.service';
import {AppointmentType} from '../../../../../core/im-marketing/model/appointment-type';
import {AppointmentTypeService} from '../../../../../core/im-marketing/service/appointment-type.service';

@Component({
	selector: 'kt-appointment-edit',
	templateUrl: './appointment-edit.component.html',
	styleUrls: ['./appointment-edit.component.scss']
})
export class AppointmentEditComponent implements OnInit {

	minDate = new Date();
	maxDate: Date;

	appointment = new Appointment();
	appointmentTypes: AppointmentType[] = [];
	clients: Client[] = [];
	persons: Person[] = [];

	submitted = false;
	title: string;

	constructor(private httpClient: HttpClient,
				private appointmentService: AppointmentService,
				private appointmentTypeService: AppointmentTypeService,
				private clientService: ClientService,
				private personService: PersonService,
				public dialogRef: MatDialogRef<AppointmentListComponent>,
				@Inject(MAT_DIALOG_DATA) public data: any) {
	}

	ngOnInit() {
		if (this.minDate.getMonth() + 7 > 12) {
			this.maxDate = new Date(this.minDate.getFullYear() + 1, this.minDate.getMonth() + 7 - 12, 0);
		} else {
			this.maxDate = new Date(this.minDate.getFullYear(), this.minDate.getMonth() + 7, 0);
		}
		console.log(this.minDate.getFullYear(), this.minDate.getMonth() + 7);
		if (this.data.id) {
			this.title = 'Modifier le rendez-vous numéro: ' + this.data.id;
			this.getAppointment();
		} else {
			this.title = 'Créer un rendez-vous';
		}

	}

	closeDialog(): void {
		this.dialogRef.close();
	}

	getAppointment() {
		this.appointmentService.getByOne(this.data.id)
			.subscribe(
				data => {
					this.appointment = data.body;
					this.getAllClients();
					this.getAllPersons();
					this.getAllAppointmentType();

					console.log(JSON.stringify(this.appointment));
				},
				error => {
					console.log(error);
				}
			);


	}

	getAllClients() {
		this.clientService.getAll()
			.subscribe(
				data => {
					this.clients = data.body;
					console.log('client list :' + JSON.stringify(this.clients));
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

					console.log(' appointmentType list :' + JSON.stringify(this.appointmentTypes));
				},
				error => {
					console.log(error);
				}
			);

	}

	getAllPersons() {
		this.personService.getAll()
			.subscribe(
				data => {
					this.persons = data.body;
					console.log('person list : ' + JSON.stringify(this.persons));
				},
				error => {
					console.log(error);
				}
			);

	}


	createOrUpdateAppointment() {
		console.log(this.appointment);
		if (this.data.id) {
			this.appointmentService.update(this.data.id, this.appointment)
				.subscribe(
					data => {
						console.log(this.data);
						this.submitted = true;
					},
					error => {
						console.log(error);
					}
				);

		} else {
			this.appointmentService.create(this.appointment)
				.subscribe(
					data => {
						console.log(this.data);
						this.submitted = true;
					},
					error => {
						console.log(error);
					}
				);
		}

		this.closeDialog();
	}


}
