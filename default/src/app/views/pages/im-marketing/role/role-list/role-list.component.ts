import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';
import {Role} from '../../../../../core/im-marketing/model/role';
import {RoleService} from '../../../../../core/im-marketing/service/role.service';
import {RoleEditComponent} from '../role-edit/role-edit.component';
import {ConfirmDialogComponent, ConfirmDialogModel} from '../../confirm/confirm-dialog/confirm-dialog.component';
import {HouseTypeService} from '../../../../../core/im-marketing/service/house-type.service';

@Component({
	selector: 'kt-role-list',
	templateUrl: './role-list.component.html',
	styleUrls: ['./role-list.component.scss']
})
export class RoleListComponent implements OnInit {

	constructor(private httpClient: HttpClient,
				private roleService: RoleService,
				private dialog: MatDialog,
				private cdr: ChangeDetectorRef) {
	}

	roles: Role[] = [];

	displayedColumns = ['id', 'roleName', 'action'];
	dataSource = new MatTableDataSource();
	private confirm: boolean = false;

	@ViewChild(MatPaginator) paginator: MatPaginator;

	ngOnInit() {
		this.getAllRoles();
	}


	getAllRoles() {
		this.roleService.getAll()
			.subscribe(
				data => {
					this.roles = data.body;
					console.log(this.roles);
					this.dataSource = new MatTableDataSource<Role>(this.roles);
					this.cdr.detectChanges();
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			)
		;

	}

	deleteRole(role: Role) {


	}

	/**
	 * Set the paginator after the view init since this component will
	 * be able to query its view for the initialized paginator.
	 */
	// tslint:disable-next-line:use-life-cycle-interface
	ngAfterViewInit() {
		this.dataSource.paginator = this.paginator;
	}

	editHouseType(element: Role) {

	}

	openDialog(id?): void {
		let dialogRef = this.dialog.open(RoleEditComponent, {
			width: '60%',
			height: '50%',
			data: {id}
		});

		dialogRef.afterClosed().subscribe(result => {
			this.getAllRoles();
			console.log('The dialog was closed');

		});
	}

	confirmDialog(id): void {
		const message = `Voulez-vous supprimer le Role? ` + id;

		const dialogData = new ConfirmDialogModel('Confirmation', message);

		const dialogRef = this.dialog.open(ConfirmDialogComponent, {
			maxWidth: '400px',
			data: dialogData
		});

		dialogRef.afterClosed().subscribe(dialogResult => {
			this.confirm = dialogResult;
			if (this.confirm) {
				this.deleteRole(id);
			}
		});

	}
}
