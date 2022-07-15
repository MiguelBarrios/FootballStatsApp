import { Component, OnInit } from '@angular/core';
import { TeamService } from 'src/app/services/team.service';

@Component({
  selector: 'app-matchup',
  templateUrl: './matchup.component.html',
  styleUrls: ['./matchup.component.css']
})
export class MatchupComponent implements OnInit {

  constructor(private teamService:TeamService) { }

  ngOnInit(): void {
    this.teamService.getTeams().subscribe(
      (data) => {
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    )
  }

}
