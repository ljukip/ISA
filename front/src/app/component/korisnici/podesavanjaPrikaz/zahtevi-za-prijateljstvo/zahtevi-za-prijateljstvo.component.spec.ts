import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZahteviZaPrijateljstvoComponent } from './zahtevi-za-prijateljstvo.component';

describe('ZahteviZaPrijateljstvoComponent', () => {
  let component: ZahteviZaPrijateljstvoComponent;
  let fixture: ComponentFixture<ZahteviZaPrijateljstvoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZahteviZaPrijateljstvoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZahteviZaPrijateljstvoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
