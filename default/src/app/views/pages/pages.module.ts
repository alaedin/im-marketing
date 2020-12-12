// Angular
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
// NgBootstrap
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
// Partials
import {PartialsModule} from '../partials/partials.module';
// Pages
import {MailModule} from './apps/mail/mail.module';
import {ECommerceModule} from './apps/e-commerce/e-commerce.module';
import {UserManagementModule} from './user-management/user-management.module';
import {CoreModule} from '../../core/core.module';
import {MyPageComponent} from './my-page/my-page.component';

import {RouterModule} from '@angular/router';
import {HouseTypeEditComponent} from './im-marketing/houseType/house-type-edit/house-type-edit.component';
import {HouseTypeListComponent} from './im-marketing/houseType/house-type-list/house-type-list.component';
import {AppointmentTypeEditComponent} from './im-marketing/appointmentType/appointment-type-edit/appointment-type-edit.component';
import {AppointmentTypeListComponent} from './im-marketing/appointmentType/appointment-type-list/appointment-type-list.component';
import {ConfigurationComponent} from './im-marketing/configuration/configuration.component';
import {RoleComponent} from './im-marketing/role/role/role.component';
import {RoleListComponent} from './im-marketing/role/role-list/role-list.component';
import {RoleEditComponent} from './im-marketing/role/role-edit/role-edit.component';
import {PersonListComponent} from './im-marketing/person/person-list/person-list.component';
import {PersonEditComponent} from './im-marketing/person/person-edit/person-edit.component';
import {PhoneListComponent} from './im-marketing/phone/phone-list/phone-list.component';
import {PhoneEditComponent} from './im-marketing/phone/phone-edit/phone-edit.component';
import {CompanyListComponent} from './im-marketing/company/company-list/company-list.component';
import {CompanyEditComponent} from './im-marketing/company/company-edit/company-edit.component';
import {FactureComponent} from './im-marketing/facture/facture.component';
import {CommerctComponent} from './im-marketing/facture/commerct/commerct.component';
import {ClientListComponent} from './im-marketing/client/client-list/client-list.component';
import {ClientEditComponent} from './im-marketing/client/client-edit/client-edit.component';
import {AppointmentEditGeneralComponent} from './im-marketing/appointment/edit/appointment-edit-general/appointment-edit-general.component';
import {AppointmentComponent} from './im-marketing/appointment/appointment/appointment.component';
import {ConfirmDialogComponent} from './im-marketing/confirm/confirm-dialog/confirm-dialog.component';
import {
	MatButtonModule,
	MatCardModule, MatDatepickerModule,
	MatDialogModule, MatExpansionModule,
	MatFormFieldModule,
	MatGridListModule,
	MatIconModule,
	MatInputModule,
	MatPaginatorModule,
	MatProgressSpinnerModule, MatRadioModule, MatSelectModule, MatSlideToggleModule,
	MatTableModule
} from '@angular/material';
import {AppointmentEditComponent} from './im-marketing/appointment/appointment-edit/appointment-edit.component';
import {AppointmentListComponent} from './im-marketing/appointment/appointment-list/appointment-list.component';

@NgModule({

	declarations: [
		MyPageComponent,
		HouseTypeEditComponent,
		HouseTypeListComponent,
		AppointmentTypeEditComponent,
		AppointmentTypeListComponent,
		ConfigurationComponent,
		RoleComponent,
		RoleListComponent,
		RoleEditComponent,
		PersonListComponent,
		PersonEditComponent,
		PhoneListComponent,
		PhoneEditComponent,
		CompanyListComponent,
		CompanyEditComponent,
		FactureComponent,
		CommerctComponent,
		ClientListComponent,
		ClientEditComponent,
		AppointmentEditComponent,
		AppointmentListComponent,
		AppointmentComponent,
		AppointmentEditGeneralComponent,
		ConfirmDialogComponent],

	exports: [PersonListComponent, ClientListComponent, RoleListComponent],
	imports: [
		CommonModule,
		HttpClientModule,
		FormsModule,
		NgbModule,
		CoreModule,
		PartialsModule,
		MailModule,
		ECommerceModule,
		UserManagementModule,
		ReactiveFormsModule,
		MatProgressSpinnerModule,
		MatFormFieldModule,
		MatDialogModule,
		MatPaginatorModule,
		MatTableModule,
		MatInputModule,
		MatIconModule,
		MatButtonModule,
		MatCardModule,
		MatGridListModule,
		MatDatepickerModule,
		MatSelectModule,
		MatExpansionModule,
		RouterModule,
		MatRadioModule,
		MatSlideToggleModule,
	],
	entryComponents: [
		PersonEditComponent,
		RoleEditComponent,
		AppointmentTypeEditComponent,
		ClientEditComponent,
		AppointmentEditComponent,
		AppointmentEditGeneralComponent,
		ConfirmDialogComponent,
		HouseTypeEditComponent,
	],
	providers: []
})
export class PagesModule {
}
