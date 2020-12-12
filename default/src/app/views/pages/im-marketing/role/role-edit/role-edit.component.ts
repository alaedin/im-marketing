import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RoleService} from '../../../../../core/im-marketing/service/role.service';
import {MAT_DIALOG_DATA, MatDialogRef, MatPaginator, MatTableDataSource} from '@angular/material';
import {RoleListComponent} from '../role-list/role-list.component';
import {Role} from '../../../../../core/im-marketing/model/role';

@Component({
	selector: 'kt-role-edit',
	templateUrl: './role-edit.component.html',
	styleUrls: ['./role-edit.component.scss']
})
export class RoleEditComponent implements OnInit {
	roles: Role[] = [];
	role = new Role();
	dataSource: MatTableDataSource<Role>;
	submitted: boolean = false;
	private title: string;

	constructor(private httpClient: HttpClient,
				private roleService: RoleService,
				public dialogRef: MatDialogRef<RoleListComponent>,
				@Inject(MAT_DIALOG_DATA) public data: any) {
	}

	ngOnInit() {
		console.log(this.data);
		if (this.data.id) {
			this.title = 'Modifier le role N°: ' + this.data.id;
			this.getRole(this.data.id);
		} else {
			this.title = 'Créer un role';
		}
	}

	onNoClick(): void {
		this.dialogRef.close();
	}

	getRole(id?) {
		this.roleService.getByOne(this.data.id)
			.subscribe(
				data => {
					this.role = data.body;
					this.getAllRoles();
					console.log(this.role);
				},
				error => {
					console.log(error);
				}
			);

	}

	getAllRoles() {
		this.roleService.getAll()
			.subscribe(
				data => {
					this.roles = data.body;
					console.log(this.roles);
					this.dataSource = new MatTableDataSource<Role>(this.roles);
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			);

	}




	createOrUpdateClient() {
		if (this.data.id) {
			this.roleService.update(this.data.id, this.role)
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
			this.roleService.create(this.role)
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
