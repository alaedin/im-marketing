import {Component, Inject, OnInit} from '@angular/core';
import {HouseType} from '../../../../../core/im-marketing/model/house-type';
import {FormGroup} from '@angular/forms';
import {HouseTypeService} from '../../../../../core/im-marketing/service/house-type.service';
import {MAT_DIALOG_DATA, MatDialogRef, MatTableDataSource} from '@angular/material';
import {ClientListComponent} from '../../client/client-list/client-list.component';
import {HttpClient} from '@angular/common/http';

@Component({
	selector: 'kt-house-type-edit',
	templateUrl: './house-type-edit.component.html',
	styleUrls: ['./house-type-edit.component.scss']
})
export class HouseTypeEditComponent implements OnInit {
	dataSource: MatTableDataSource<HouseType>;

	constructor(private houseTypeService: HouseTypeService,
				private http: HttpClient,
				public dialogRef: MatDialogRef<ClientListComponent>,
				@Inject(MAT_DIALOG_DATA) public data: any) {
	}

	viewLoading: boolean = false;
	houseType = new HouseType();
	hasFormErrors: boolean = false;
	submitted = false;
	title: string = '';

	ngOnInit() {
		console.log(this.data);
		if (this.data.id) {
			this.title = 'Modifier Type de maison N°: ' + this.data.id;
			this.getOne(this.data.id);
		} else {
			this.title = 'Créer un type de maison';
		}
	}

	getOne(id) {
		this.houseTypeService.getByOne(id).subscribe(
			data => {
				this.dataSource = data.body;
				console.log(this.dataSource);
			},
			error => {
				console.log(error);
			}
		);
	}

	createOrUpdateClient() {
		if (this.data.id) {
			this.houseTypeService.update(this.data.id, this.houseType)
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
			this.houseTypeService.create(this.houseType)
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

	closeDialog(): void {
		this.dialogRef.close();
	}


}
