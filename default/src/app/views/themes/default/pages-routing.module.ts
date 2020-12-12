// Angular
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
// Components
import {BaseComponent} from './base/base.component';
import {ErrorPageComponent} from './content/error-page/error-page.component';
// Auth
import {AuthGuard} from '../../../core/auth';

// My Component
import {PhoneListComponent} from '../../pages/im-marketing/phone/phone-list/phone-list.component';
import {ClientListComponent} from '../../pages/im-marketing/client/client-list/client-list.component';
import {FactureComponent} from '../../pages/im-marketing/facture/facture.component';
import {HouseTypeListComponent} from '../../pages/im-marketing/houseType/house-type-list/house-type-list.component';
import {PersonListComponent} from '../../pages/im-marketing/person/person-list/person-list.component';
import {ConfigurationComponent} from '../../pages/im-marketing/configuration/configuration.component';
import {AppointmentListComponent} from '../../pages/im-marketing/appointment/appointment-list/appointment-list.component';
import {MyPageComponent} from '../../pages/my-page/my-page.component';
import {AppointmentComponent} from '../../pages/im-marketing/appointment/appointment/appointment.component';

const routes: Routes = [
	{
		path: '',
		component: BaseComponent,
		canActivate: [AuthGuard],
		children: [
			{
				path: 'repertoire', // <= Page URL
				component: PhoneListComponent // <= Page component registration
			},
			{
				path: 'contacts', // <= Page URL
				component: ClientListComponent // <= Page component registration
			},
			{
				path: 'facture', // <= Page URL
				component: FactureComponent // <= Page component registration
			},
			{
				path: 'type-house', // <= Page URL
				component: HouseTypeListComponent // <= Page component registration
			},
			{
				path: 'commercial', // <= Page URL
				component: PersonListComponent // <= Page component registration
			},
			{
				path: 'configuration', // <= Page URL
				component: ConfigurationComponent // <= Page component registration
			},
			{
				path: 'rendez-vous', // <= Page URL
				component: AppointmentListComponent // <= Page component registration
			},
			{
				path: 'rendez-vous-comm', // <= Page URL
				component: AppointmentComponent // <= Page component registration
			}/*,
			{
				path: 'dashboard',
				loadChildren: 'app/views/pages/dashboard/dashboard.module#DashboardModule'
			}*/,{
				path: 'my-page', // <= Page URL
				component: MyPageComponent // <= Page component registration
			},
			// {
			// 	path: 'mail',
			// 	loadChildren: 'app/views/pages/apps/mail/mail.module#MailModule'
			// },
			/*{
				path: 'ecommerce',
				loadChildren: 'app/views/pages/apps/e-commerce/e-commerce.module#ECommerceModule',
				// canActivate: [NgxPermissionsGuard],
				// data: {
				//  	permissions: {
				//  		only: ['accessToECommerceModule'],
				//  		redirectTo: 'error/403'
				// 	}
				// }
			},*/
			{
				path: 'ngbootstrap',
				loadChildren: 'app/views/pages/ngbootstrap/ngbootstrap.module#NgbootstrapModule'
			},
			{
				path: 'material',
				loadChildren: 'app/views/pages/material/material.module#MaterialModule'
			},
			{
				path: 'user-management',
				loadChildren: 'app/views/pages/user-management/user-management.module#UserManagementModule'
			},
			{
				path: 'builder',
				loadChildren: 'app/views/themes/default/content/builder/builder.module#BuilderModule'
			},
			{
				path: 'error/403',
				component: ErrorPageComponent,
				data: {
					'type': 'error-v6',
					'code': 403,
					'title': '403... Access forbidden',
					'desc': 'Looks like you don\'t have permission to access for requested page.<br> Please, contact administrator'
				}
			},
			{path: 'error/:type', component: ErrorPageComponent},
			{path: '', redirectTo: 'dashboard', pathMatch: 'full'},
			{path: '**', redirectTo: 'dashboard', pathMatch: 'full'}
		]
	},
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule]
})
export class PagesRoutingModule {
}
