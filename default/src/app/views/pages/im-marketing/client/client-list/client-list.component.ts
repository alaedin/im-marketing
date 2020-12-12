import {Person} from '../../../../../core/im-marketing/model/person';
import {ClientService} from '../../../../../core/im-marketing/service/client.service';
import {Client} from '../../../../../core/im-marketing/model/client';
import {ClientEditComponent} from '../client-edit/client-edit.component';
import {ConfirmDialogComponent, ConfirmDialogModel} from '../../confirm/confirm-dialog/confirm-dialog.component';
import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {HttpClient} from '@angular/common/http';

@Component({
	selector: 'kt-client-list',
	templateUrl: './client-list.component.html',
	styleUrls: ['./client-list.component.scss']
})
export class ClientListComponent implements OnInit {

	@ViewChild(MatPaginator) paginator: MatPaginator;

	clients: Client[] = [];

	displayedColumns = ['id', 'firstName', 'lastName', 'brithdate', 'address', 'email', 'phone', 'action'];
	dataSource = new MatTableDataSource();
	confirm: boolean = false;
	constructor(private httpClient: HttpClient,
				private clientService: ClientService,
				public dialog: MatDialog,
				private cdr: ChangeDetectorRef) {
	}

	ngOnInit() {
		this.getAllClients();
	}


	getAllClients() {
		this.clientService.getAll()
			.subscribe(
				data => {
					this.clients = data.body;
					console.log(this.clients);
					this.dataSource = new MatTableDataSource<Client>(this.clients);
					this.cdr.detectChanges();
					console.log(this.dataSource);
				},
				error => {
					console.log(error);
				}
			);

	}

	deleteClient(id) {
			this.clientService.delete(id)
				.subscribe(data => {
					this.clients = this.clients.filter(c => c.id !== id);
					this.dataSource = new MatTableDataSource<Client>(this.clients);
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
		let dialogRef = this.dialog.open(ClientEditComponent, {
			width: '60%',
			height: '45%',
			data: {id}
		});
		dialogRef.afterClosed().subscribe(result => {
			this.getAllClients();

			console.log('The dialog was closed');

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
				this.deleteClient(id);
			}
		});
	}
}
