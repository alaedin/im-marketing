import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class HouseTypeService {

	public uri = environment.proxyUrl + environment.imMarketing + '/im-workspace/house-type';

	constructor(private http: HttpClient) {
	}


	getAll(): Observable<any> {
		return this.http.get(this.uri);
	}

	create(data): Observable<any> {
		return this.http.post(this.uri + '/add', data);
	}

	update(id, data): Observable<any> {
		return this.http.put(this.uri + '/update/${id}', data);
	}

	delete(id): Observable<any> {
		return this.http.delete('${uri}/${id}');
	}

	deleteAll(): Observable<any> {
		return this.http.delete(this.uri);
	}

	getByHouseTypeName(houseTypeName): Observable<any> {
		return this.http.get(`${this.uri}?houseTypeName=${houseTypeName}`);
	}

	getByOne(id): Observable<any> {
		return this.http.get<any>(this.uri + '/' + id);
	}
}
