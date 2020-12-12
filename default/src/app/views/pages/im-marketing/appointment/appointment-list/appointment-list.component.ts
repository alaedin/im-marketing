import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';
import {Person} from '../../../../../core/im-marketing/model/person';
import {Appointment} from '../../../../../core/im-marketing/model/appointment';
import {AppointmentService} from '../../../../../core/im-marketing/service/appointment.service';
import {AppointmentEditComponent} from '../appointment-edit/appointment-edit.component';

@Component({
	selector: 'kt-appointment-list',
	templateUrl: './appointment-list.component.html',
	styleUrls: ['./appointment-list.component.scss']
})
export class AppointmentListComponent implements OnInit {


	@ViewChild(MatPaginator) paginator: MatPaginator;

	appointment: Appointment[] = [];

	displayedColumns = ['id', 'appointmentDate', 'prix', 'tax', 'person', 'client', 'appointmentType', 'action'];
	dataSource = new MatTableDataSource();

	constructor(private httpClient: HttpClient,
				private appointmentService: AppointmentService,
				public dialog: MatDialog) {
	}

	ngOnInit() {
		this.getAllAppointment();
	}


	getAllAppointment() {
		this.appointmentService.getAll()
			.subscribe(
				data => {
					this.appointment = data.body;
					console.log(this.appointment);
					this.dataSource = new MatTableDataSource<Appointment>(this.appointment);
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			);

	}

	deleteAppointment(id) {


	}


	/**
	 * Set the paginator after the view init since this component will
	 * be able to query its view for the initialized paginator.
	 */
	// tslint:disable-next-line:use-life-cycle-interface
	ngAfterViewInit() {
		this.dataSource.paginator = this.paginator;
	}

	editAppointment(element: Person) {

	}

	openDialog(id?): void {
		let dialogRef = this.dialog.open(AppointmentEditComponent, {
			width: '60%',
			height: '45%',
			data: {id}
		});
		this.getAllAppointment();
		dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');

		});
	}

}

