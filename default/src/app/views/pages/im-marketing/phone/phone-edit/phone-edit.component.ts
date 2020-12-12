import {Component, OnInit, ViewChild} from '@angular/core';
import {Role} from '../../../../../core/im-marketing/model/role';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Phone} from '../../../../../core/im-marketing/model/phone';
import {PersonService} from '../../../../../core/im-marketing/service/person.service';
import {PhoneService} from '../../../../../core/im-marketing/service/phone.service';
import {Person} from '../../../../../core/im-marketing/model/person';

@Component({
  selector: 'kt-phone-edit',
  templateUrl: './phone-edit.component.html',
  styleUrls: ['./phone-edit.component.scss']
})
export class PhoneEditComponent implements OnInit {
	@ViewChild(MatPaginator) paginator: MatPaginator;
	phone: Phone[] = [];

	displayedColumns = ['zone', 'phone', 'contact'];
	dataSource = new MatTableDataSource();
  constructor(private phoneService: PhoneService) { }

  ngOnInit() {
  }
	getAllPhones() {
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
}
