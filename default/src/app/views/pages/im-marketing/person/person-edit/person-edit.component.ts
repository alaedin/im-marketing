import {Component, Inject, OnInit} from '@angular/core';
import {PersonListComponent} from '../person-list/person-list.component';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Person} from '../../../../../core/im-marketing/model/person';
import {HttpClient} from '@angular/common/http';
import {PersonService} from '../../../../../core/im-marketing/service/person.service';
import {FormControl, Validators} from '@angular/forms';
import {Role} from '../../../../../core/im-marketing/model/role';
import {Phone} from '../../../../../core/im-marketing/model/phone';
import {RoleService} from '../../../../../core/im-marketing/service/role.service';

@Component({
	selector: 'kt-person-edit',
	templateUrl: './person-edit.component.html',
	styleUrls: ['./person-edit.component.scss']
})
export class PersonEditComponent implements OnInit {

	minDate = new Date(1900, 0, 1);
	maxDate = new Date();
	emailFormControl = new FormControl('', [
		Validators.required,
		Validators.email,
	]);
	person = new Person();
	commercials: Person[] = [];
	roles: Role[] = [];
	role = new Role();
	phone = new Phone();
	submitted = false;
	title: string;

	constructor(private httpClient: HttpClient,
				private personService: PersonService,
				private roleService: RoleService,
				public dialogRef: MatDialogRef<PersonListComponent>,
				@Inject(MAT_DIALOG_DATA) public data: any) {
	}

	ngOnInit() {
		console.log(this.data);
		if (!this.data.id) {
			this.title = 'Créer un commerçant';
			console.log('init wi');
		} else {
			this.title = 'Modifier le commerçant numéro: ';
			// @ts-ignore
			this.getPerson(this.data.id);
		}

		this.getAllRole();


	}

	closeDialog(): void {
		this.dialogRef.close();
	}

	getPerson(id) {
		this.personService.getByOne(id)
			.subscribe(
				data => {
					this.person = data.body;
					this.getAllRole();
					console.log(this.person);
				},
				error => {
					console.log(error);
				}
			);


	}

	getAllRole() {
		this.roleService.getAll()
			.subscribe(
				data => {
					this.roles = data.body;
				},
				error => {
					console.log(error);
				}
			);

	}

	getPersonByRole(roleId) {
		this.personService.getByRole(roleId)
			.subscribe(
				data => {
					this.roles = data.body;
					console.log(this.commercials);
				}, error => {
					console.log(error);
				}
			);
	}

	createOrUpdatePerson() {
		this.person.email = this.emailFormControl.value;
		this.person.phone = this.phone;
		this.person.role = this.role;
		if (!this.data.id) {
			console.log('create person');
			console.log(JSON.stringify(this.person));
			this.personService.create(this.person)
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
			this.personService.update(this.data.id, this.person)
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

}
