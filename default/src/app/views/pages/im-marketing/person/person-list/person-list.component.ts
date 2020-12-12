import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';
import {Person} from '../../../../../core/im-marketing/model/person';
import {Role} from '../../../../../core/im-marketing/model/role';
import {PersonService} from '../../../../../core/im-marketing/service/person.service';
import {PersonEditComponent} from '../person-edit/person-edit.component';
import {RoleService} from '../../../../../core/im-marketing/service/role.service';
import {ConfirmDialogComponent, ConfirmDialogModel} from '../../confirm/confirm-dialog/confirm-dialog.component';
import {Client} from '../../../../../core/im-marketing/model/client';

@Component({
	selector: 'kt-person-list',
	templateUrl: './person-list.component.html',
	styleUrls: ['./person-list.component.scss']
})
export class PersonListComponent implements OnInit {
	@ViewChild(MatPaginator) paginator: MatPaginator;

	persons: Person[] = [];
	role: Role[] = [];

	displayedColumns = ['id', 'firstName', 'lastName', 'brithdate', 'address', 'role', 'email', 'phone', 'action'];
	dataSource = new MatTableDataSource();
	confirm: boolean = false;

	constructor(private httpClient: HttpClient,
				private personService: PersonService,
				public dialog: MatDialog,
				private roleService: RoleService,
				private cdr: ChangeDetectorRef) {
	}

	ngOnInit() {
		this.getAllPersons();
	}

	getAllRoles() {
		this.roleService.getAll()
			.subscribe(
				data => {
					this.role = data.body;
				},
				error => {
					console.log(error);
				}
			);

	}

	getAllPersons() {
		this.personService.getAll()
			.subscribe(
				data => {
					this.persons = data.body;
					this.getAllRoles();
					console.log(this.persons);
					this.dataSource = new MatTableDataSource<Person>(this.persons);
					this.cdr.detectChanges();
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			);

	}

	deletePerson(id) {
		this.personService.delete(id)
			.subscribe(data => {
				this.persons = this.persons.filter(c => c.id !== id);
				this.dataSource = new MatTableDataSource<Client>(this.persons);
				this.cdr.detectChanges();
			})
		;

	}



	/**
	 * Set the paginator after the view init since this component will
	 * be able to query its view for the initialized paginator.
	 */
	// tslint:disable-next-line:use-life-cycle-interface
	ngAfterViewInit() {
		this.dataSource.paginator = this.paginator;
	}

	editPerson(element: Person) {

	}

	openDialog(id?): void {
		let dialogRef = this.dialog.open(PersonEditComponent, {
			width: '60%',
			height: '45%',
			data: {id}
		});

		dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');
			this.getAllPersons();
		});
	}

	confirmDialog(id ): void {
		const message = `Voulez-vous supprimer le client? ` + id;

		const dialogData = new ConfirmDialogModel('Confirmation', message);

		const dialogRef = this.dialog.open(ConfirmDialogComponent, {
			maxWidth: '400px',
			data: dialogData
		});

		dialogRef.afterClosed().subscribe(dialogResult => {
			this.confirm = dialogResult;
			if (this.confirm) {
				this.deletePerson(id);
			}
		});
	}

}
