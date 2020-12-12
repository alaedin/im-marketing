import {Component, Inject, OnInit} from '@angular/core';
import {AppointmentType} from '../../../../../core/im-marketing/model/appointment-type';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {PersonListComponent} from '../../person/person-list/person-list.component';
import {HttpClient} from '@angular/common/http';
import {AppointmentTypeService} from '../../../../../core/im-marketing/service/appointment-type.service';

@Component({
	selector: 'kt-appointment-type-edit',
	templateUrl: './appointment-type-edit.component.html',
	styleUrls: ['./appointment-type-edit.component.scss']
})
export class AppointmentTypeEditComponent implements OnInit {

	appointmentTypes: AppointmentType[] = [];
	appointmentType = new AppointmentType();
	submitted: boolean = false;

	constructor(private httpClient: HttpClient,
				private appointmentService: AppointmentTypeService,
				public dialogRef: MatDialogRef<PersonListComponent>,
				@Inject(MAT_DIALOG_DATA) public data: any) {


	}


	ngOnInit() {
		console.log(this.data);
		this.getAppointmentType();
	}

	onNoClick(): void {
		this.dialogRef.close();
	}

	getAppointmentType() {
		this.appointmentService.getByOne(this.data.id)
			.subscribe(
				data => {
					this.appointmentType = data.body;
					this.getAllRole();
					console.log(this.appointmentType);
				},
				error => {
					console.log(error);
				}
			);

	}

	getAllRole() {
		this.appointmentService.getAll()
			.subscribe(
				data => {
					this.appointmentTypes = data.body;
				},
				error => {
					console.log(error);
				}
			);
	}

	updateAppointmentType() {
		this.appointmentService.update(this.appointmentType.id, this.appointmentType)
			.subscribe(
				data => {
					this.submitted = true;
				},
				error => {
					console.log(error);
				}
			);
	}
}
