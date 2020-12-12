import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {Phone} from '../../../../../core/im-marketing/model/phone';
import {HttpClient} from '@angular/common/http';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Client} from '../../../../../core/im-marketing/model/client';
import {ClientService} from '../../../../../core/im-marketing/service/client.service';
import {ClientListComponent} from '../client-list/client-list.component';

@Component({
	selector: 'kt-client-edit',
	templateUrl: './client-edit.component.html',
	styleUrls: ['./client-edit.component.scss']
})
export class ClientEditComponent implements OnInit {

	minDate = new Date(1900, 0, 1);
	maxDate = new Date();
	emailFormControl = new FormControl('', [
		Validators.required,
		Validators.email,
	]);
	client = new Client();
	phone = new Phone();
	submitted = false;
	title: string;

	constructor(private httpClient: HttpClient,
				private clientService: ClientService,
				public dialogRef: MatDialogRef<ClientListComponent>,
				@Inject(MAT_DIALOG_DATA) public data: any) {
	}

	ngOnInit() {
		console.log(this.data);
		if (this.data.id) {
			this.title = 'Modifier le Client numéro: ';
			this.getClient();
		} else {
			this.title = 'Créer un client';
		}
	}

	closeDialog(): void {
		this.dialogRef.close();
	}

	getClient(id?) {
		this.clientService.getByOne(this.data.id)
			.subscribe(
				data => {
					this.client = data.body;
					console.log(this.client);
				},
				error => {
					console.log(error);
				}
			);


	}


	createOrUpdateClient() {
		this.client.email = this.emailFormControl.value;
		console.log('client : ' + JSON.stringify(this.client));
		if (this.data.id) {
			this.clientService.update(this.data.id, this.client)
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
			this.clientService.create(this.client)
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
