import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Person} from '../../../../core/im-marketing/model/person';
import {Role} from '../../../../core/im-marketing/model/role';
import {Company} from '../../../../core/im-marketing/model/company';
import {CompanyService} from '../../../../core/im-marketing/service/company.service';

@Component({
  selector: 'kt-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.scss']
})
export class FactureComponent implements OnInit {
	@ViewChild(MatPaginator) paginator: MatPaginator;

	company: Company[] = [];
	role: Role[] = [];
	displayedColumns = ['company', 'commerct'];
	dataSource = new MatTableDataSource();
  constructor(private companyService: CompanyService) { }

  ngOnInit() {
  	this.getCompany();
  }
	getCompany() {
		this.companyService.getAll()
			.subscribe(
				data => {
					this.company = data.body;
					console.log(this.company);
					this.dataSource = new MatTableDataSource<Company>(this.company);
				},
				error => {
					console.log(error);
				}
			);

	}
}
