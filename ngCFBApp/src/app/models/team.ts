export class Team {
    name: string;
    team_url: string;
    logo_url: string;
    conference_name: string;

    constructor( name: string,
        team_url: string,
        logo_url: string,
        conference_name: string){
            this.name = name;
            this.team_url = team_url;
            this.logo_url = logo_url;
            this.conference_name = conference_name;
        }

}
