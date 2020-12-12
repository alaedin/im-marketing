import {Component, OnInit, ViewChild} from '@angular/core';
import {HouseType} from '../../../../../core/im-marketing/model/house-type';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';
import {AppointmentType} from '../../../../../core/im-marketing/model/appointment-type';
import {AppointmentTypeService} from '../../../../../core/im-marketing/service/appointment-type.service';
import {AppointmentTypeEditComponent} from '../appointment-type-edit/appointment-type-edit.component';

@Component({
  selector: 'kt-appointment-type-list',
  templateUrl: './appointment-type-list.component.html',
  styleUrls: ['./appointment-type-list.component.scss']
})
export class AppointmentTypeListComponent implements OnInit {

	constructor(private httpClient: HttpClient,
				private appointmentTypeService: AppointmentTypeService,
				private dialog: MatDialog) {
	}

	appointmentTypeName: AppointmentType[] = [];

	displayedColumns = ['id', 'appointmentTypeName', 'action'];
	dataSource = new MatTableDataSource();

	@ViewChild(MatPaginator) paginator: MatPaginator;

	ngOnInit() {
		this.getAllAppointmentType();
	}


	getAllAppointmentType() {
		this.appointmentTypeService.getAll()
			.subscribe(
				data => {
					this.appointmentTypeName = data.body;
					console.log(this.appointmentTypeName);
					this.dataSource = new MatTableDataSource<AppointmentType>(this.appointmentTypeName);
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			)
		;

	}

	deleteAppointmentType(appointmentType: AppointmentType) {


	}

	/**
	 * Set the paginator after the view init since this component will
	 * be able to query its view for the initialized paginator.
	 */
	// tslint:disable-next-line:use-life-cycle-interface
	ngAfterViewInit() {
		this.dataSource.paginator = this.paginator;
	}

	editAppointmentType(element: HouseType) {

	}
	openDialog(id): void {
		let dialogRef = this.dialog.open(AppointmentTypeEditComponent, {
			width: '60%',
			height: '50%',
			data: {id}
		});

		dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');

		});
	}
}
