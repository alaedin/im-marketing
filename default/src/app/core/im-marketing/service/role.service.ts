import { Injectable } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoleService {


	public uri = environment.proxyUrl + environment.imMarketing + '/im-workspace/role';

	constructor(private http: HttpClient) {
	}


	getAll(): Observable<any> {
		console.log('role url');
		console.log(this.uri);
		return this.http.get(this.uri);
	}

	create(data): Observable<any> {
		return this.http.post(this.uri + '/add', data);
	}

	update(id, data): Observable<any> {
		return this.http.put('${uri}/${id}', data);
	}

	delete(id): Observable<any> {
		return this.http.delete('${uri}/${id}');
	}

	deleteAll(): Observable<any> {
		return this.http.delete(this.uri);
	}

	getByHouseTypeName(roleName): Observable<any> {
		return this.http.get(`${this.uri}/roleName/${roleName}`);
	}

	getByOne(id): Observable<any> {
		return this.http.get<any>(this.uri + '/' + id);
	}
}
