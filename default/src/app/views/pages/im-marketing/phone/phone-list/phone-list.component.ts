import {Component, OnInit, ViewChild} from '@angular/core';
import {Person} from '../../../../../core/im-marketing/model/person';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';
import {HouseType} from '../../../../../core/im-marketing/model/house-type';
import {Phone} from '../../../../../core/im-marketing/model/phone';
import {PhoneService} from '../../../../../core/im-marketing/service/phone.service';
import {PhoneEditComponent} from '../phone-edit/phone-edit.component';

@Component({
  selector: 'kt-phone-list',
  templateUrl: './phone-list.component.html',
  styleUrls: ['./phone-list.component.scss']
})
export class PhoneListComponent implements OnInit {

	constructor(private httpClient: HttpClient,
				private phoneService: PhoneService,
				public dialog: MatDialog) {
	}


	phone: Phone[] = [];

	displayedColumns = [ 'countryKey','phoneNumber', 'zone', 'action'];

	dataSource = new MatTableDataSource();

	@ViewChild(MatPaginator) paginator: MatPaginator;

	ngOnInit() {
		this.getAllPhone();
	}


	getAllPhone() {
		this.phoneService.getAll()
			.subscribe(
				data => {
					this.phone = data.body;
					console.log(this.phone);
					this.dataSource = new MatTableDataSource<Phone>(this.phone);
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			);

	}

	deletePhone(id) {


	}

	/**
	 * Set the paginator after the view init since this component will
	 * be able to query its view for the initialized paginator.
	 */
	// tslint:disable-next-line:use-life-cycle-interface
	ngAfterViewInit() {
		this.dataSource.paginator = this.paginator;
	}

	openDialog(id): void {
		let dialogRef = this.dialog.open(PhoneEditComponent, {
			width: '60%',
			height: '50%',
			data: {id}
		});

		dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');

		});
	}

}
