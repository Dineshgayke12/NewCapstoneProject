import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  orientation: string = 'vertical-navbar'; // Default orientation
  submenu_orintaion: string = 'horizontal-submenu';

  toggleOrientation() {
    this.orientation = this.orientation === 'horizontal-navbar' ? 'vertical-navbar' : 'horizontal-navbar';
    this.submenu_orintaion = this.submenu_orintaion === 'horizontal-submenu' ? 'vertical-submenu' : 'horizontal-submenu';
  }



  subNavVisibility = true;
  @ViewChild('subMenuElement') subMenuElement: ElementRef | undefined;
  handleClick() { 
 
    const nativeElement = this.subMenuElement?.nativeElement as HTMLElement;
    nativeElement.style.display = 'block';
      console.log("oiiii"); 

  }

  subMouseOut() {
    const nativeElement = this.subMenuElement?.nativeElement as HTMLElement;
    nativeElement.style.display = 'none';
  }


}
