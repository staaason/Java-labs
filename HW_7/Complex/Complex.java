package Complex;

import com.fraction.RationalFraction;

import java.util.List;

public class Complex {
    RationalFraction real;

    public Complex(RationalFraction real, RationalFraction imagine) {
        this.real = real;
        this.imagine = imagine;
    }

    public Complex() {
        this.real = new RationalFraction(0, 0);
        this.imagine = new RationalFraction(0, 0);
    }

    @Override
    public String toString() {
        return "Complex{" + real + " " + imagine + 'i' +  '}';
    }

    public RationalFraction getReal() {
        return real;
    }

    public void setReal(RationalFraction real) {
        this.real = real;
    }

    public RationalFraction getImagine() {
        return imagine;
    }

    public void setImagine(RationalFraction imagine) {
        this.imagine = imagine;
    }

    public  Complex addComplex(Complex other){
        RationalFraction cRe = real.add(other.getReal());
        RationalFraction cIm = imagine.add(other.getReal());
        return new Complex(cRe, cIm);
    }

    public  Complex mulComplex(Complex other){
        RationalFraction cRe = (real.mul(other.getReal())).sub(imagine.mul(other.getImagine()));
        RationalFraction cIm = (real.mul(other.getImagine())).add(imagine.mul(other.getReal()));
        return new Complex(cRe, cIm);
    }
    RationalFraction imagine;
}
