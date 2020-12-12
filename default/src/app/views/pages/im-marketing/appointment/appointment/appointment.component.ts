import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {Person} from '../../../../../core/im-marketing/model/person';
import {HttpClient} from '@angular/common/http';
import {AppointmentService} from '../../../../../core/im-marketing/service/appointment.service';
import {PersonService} from '../../../../../core/im-marketing/service/person.service';
import {MatDialog, MatPaginator, MatSelectChange, MatSort, MatTableDataSource} from '@angular/material';
import {Appointment} from '../../../../../core/im-marketing/model/appointment';
import {AppointmentEditGeneralComponent} from '../edit/appointment-edit-general/appointment-edit-general.component';

@Component({
	selector: 'kt-appointment',
	templateUrl: './appointment.component.html',
	styleUrls: ['./appointment.component.scss']
})
export class AppointmentComponent implements OnInit {

	persons: Person[] = [];
	appointment: Appointment[] = [];
	selected;

	displayedColumns = ['id', 'client', 'date', 'time', 'price', 'tax', 'action'];
	dataSource = new MatTableDataSource();

	@ViewChild(MatPaginator) paginator: MatPaginator;
	@ViewChild(MatSort) sort: MatSort;

	constructor(private httpClient: HttpClient,
				private cdr: ChangeDetectorRef,
				private appointmentService: AppointmentService,
				private personService: PersonService,
				private dialog: MatDialog) {
	}


	ngOnInit() {
		this.getAllPersons();
	}

	getAllPersons() {
		this.personService.getAll()
			.subscribe(
				data => {
					this.persons = data.body;
					this.selected = this.persons[0].id;
					this.getAppointmentByPerson(this.selected);
					this.cdr.detectChanges();

				},
				error => {
					console.log('erro is \n' + error);
				}
			);

	}

	getAppointmentByPerson(id) {
		this.appointmentService.getByPersonId(id)
			.subscribe(
				data => {
					this.appointment = data.body;
					this.dataSource = new MatTableDataSource<Appointment>(this.appointment);
					console.log(this.appointment);
					this.cdr.detectChanges();


				},
				error => {
					console.log(' getAppointmentByPerson \n' + error);
				}
			);
	}

	selectedCommercial($event?: MatSelectChange) {
		this.getAppointmentByPerson(this.selected);
	}

	applyFilter(event: Event) {
		const filterValue = (event.target as HTMLInputElement).value;
		this.dataSource.filter = filterValue.trim().toLowerCase();

		if (this.dataSource.paginator) {
			this.dataSource.paginator.firstPage();
		}
	}

	generateReport() {
		if (this.selected) {
			window.open('http://localhost:10003/report-generator/report/' + this.selected + '/valid-appointment', '_blank');
		}
	}

	// tslint:disable-next-line:use-life-cycle-interface
	ngAfterViewInit() {
		this.dataSource.paginator = this.paginator;
		this.dataSource.sort = this.sort;
	}

	deleteAppointment(id: any) {
		this.appointmentService.delete(id);

	}

	openDialog(id: any) {
		let dialogRef = this.dialog.open(AppointmentEditGeneralComponent, {
			data: {id}
		});
		this.getAllPersons();
		dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');
			this.getAppointmentByPerson(this.selected);
		});
	}


}
