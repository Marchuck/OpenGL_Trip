package com.luk.tinykartpreacher;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class CustomLukasynoRenderer implements Renderer {

	private CustomTriangle trojkat;

	public CustomLukasynoRenderer() {
		trojkat = new CustomTriangle();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glDisable(GL10.GL_DITHER);

		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		gl.glClearColor(.8f, 0f, .2f, 1f);
		gl.glClearDepthf(1f);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		float ratio = (float) width / height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glFrustumf(-ratio, ratio, -1, .5f, 1, 30);

	}

	@Override
	public void onDrawFrame(GL10 gl) {

		gl.glDisable(GL10.GL_DITHER);

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		GLU.gluLookAt(gl, 0, 0, - 29, 0, 0, 0, 0, 2, 0);

		trojkat.draw(gl);
	}

}
