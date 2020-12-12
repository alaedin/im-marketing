import { Injectable } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentTypeService {

	public uri = environment.proxyUrl + environment.imMarketing + '/im-workspace/appointment-type';

  constructor(private httpClient: HttpClient) { }


	getAll(): Observable<any> {
		return this.httpClient.get(this.uri);
	}

	create(data): Observable<any> {
		return this.httpClient.post(this.uri, data);
	}

	update(id, data): Observable<any> {
		return this.httpClient.put('${uri}/${id}', data);
	}

	delete(id): Observable<any> {
		return this.httpClient.delete('${uri}/${id}');
	}

	deleteAll(): Observable<any> {
		return this.httpClient.delete(this.uri);
	}

	getByAppointmentTypeName(appointmentTypeName): Observable<any> {
		return this.httpClient.get(`${this.uri}?houseTypeName=${appointmentTypeName}`);
	}

	getByOne(id): Observable<any> {
		return this.httpClient.get<any>(this.uri + '/' + id);
	}
}
