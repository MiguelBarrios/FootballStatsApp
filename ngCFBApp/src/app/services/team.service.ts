import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Team } from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private url = environment.baseUrl + 'api/teams'

  constructor(private http:HttpClient) { }

  getTeams(){
    return this.http.get<Team[]>(this.url).pipe(
      catchError((err:any) => {
        console.log(err);
        return throwError("Error in team service getTeam()");
      })
    )
  }
}
