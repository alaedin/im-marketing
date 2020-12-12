import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HouseTypeService} from '../../../../../core/im-marketing/service/house-type.service';
import {HouseType} from '../../../../../core/im-marketing/model/house-type';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {HouseTypeEditComponent} from '../house-type-edit/house-type-edit.component';
import {ConfirmDialogComponent, ConfirmDialogModel} from '../../confirm/confirm-dialog/confirm-dialog.component';

@Component({
	selector: 'kt-house-type-list',
	templateUrl: './house-type-list.component.html',
	styleUrls: ['./house-type-list.component.scss']
})
export class HouseTypeListComponent implements OnInit {

	constructor(private httpClient: HttpClient,
				public dialog: MatDialog,
				private houseTypeService: HouseTypeService,
				private cdr: ChangeDetectorRef) {
	}

	houseTypes: HouseType[] = [];

	displayedColumns = ['id', 'houseTypeName', 'action'];
	dataSource = new MatTableDataSource();
	confirm: boolean = false;

	@ViewChild(MatPaginator) paginator: MatPaginator;

	ngOnInit() {
		this.getAllHouseType();
	}


	getAllHouseType() {
		this.houseTypeService.getAll()
			.subscribe(
				data => {
					this.houseTypes = data.body;
					console.log(this.houseTypes);
					this.dataSource = new MatTableDataSource<HouseType>(this.houseTypes);
					this.cdr.detectChanges();
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			)
		;

	}

	deleteHouseType(houseType: HouseType) {


	}

	/**
	 * Set the paginator after the view init since this component will
	 * be able to query its view for the initialized paginator.
	 */
	// tslint:disable-next-line:use-life-cycle-interface
	ngAfterViewInit() {
		this.dataSource.paginator = this.paginator;
	}

	editHouseType(element: HouseType) {

	}

	openDialog(id?): void {
		let dialogRef = this.dialog.open(HouseTypeEditComponent, {
			width: '60%',
			height: '50%',
			data: {id}
		});

		dialogRef.afterClosed().subscribe(result => {
			this.getAllHouseType();
			console.log('The dialog was closed');

		});
	}

	confirmDialog(id): void {
		const message = `Voulez-vous supprimer le client? ` + id;

		const dialogData = new ConfirmDialogModel('Confirmation', message);

		const dialogRef = this.dialog.open(ConfirmDialogComponent, {
			maxWidth: '400px',
			data: dialogData
		});

		dialogRef.afterClosed().subscribe(dialogResult => {
			this.confirm = dialogResult;
			if (this.confirm) {
				this.deleteHouseType(id);
			}
		});

	}
}
