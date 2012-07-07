package com.openappengine.product



import org.junit.*
import grails.test.mixin.*

@TestFor(ProductGemStoneController)
@Mock(ProductGemStone)
class ProductGemStoneControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/productGemStone/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.productGemStoneInstanceList.size() == 0
        assert model.productGemStoneInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.productGemStoneInstance != null
    }

    void testSave() {
        controller.save()

        assert model.productGemStoneInstance != null
        assert view == '/productGemStone/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/productGemStone/show/1'
        assert controller.flash.message != null
        assert ProductGemStone.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/productGemStone/list'


        populateValidParams(params)
        def productGemStone = new ProductGemStone(params)

        assert productGemStone.save() != null

        params.id = productGemStone.id

        def model = controller.show()

        assert model.productGemStoneInstance == productGemStone
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/productGemStone/list'


        populateValidParams(params)
        def productGemStone = new ProductGemStone(params)

        assert productGemStone.save() != null

        params.id = productGemStone.id

        def model = controller.edit()

        assert model.productGemStoneInstance == productGemStone
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/productGemStone/list'

        response.reset()


        populateValidParams(params)
        def productGemStone = new ProductGemStone(params)

        assert productGemStone.save() != null

        // test invalid parameters in update
        params.id = productGemStone.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/productGemStone/edit"
        assert model.productGemStoneInstance != null

        productGemStone.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/productGemStone/show/$productGemStone.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        productGemStone.clearErrors()

        populateValidParams(params)
        params.id = productGemStone.id
        params.version = -1
        controller.update()

        assert view == "/productGemStone/edit"
        assert model.productGemStoneInstance != null
        assert model.productGemStoneInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/productGemStone/list'

        response.reset()

        populateValidParams(params)
        def productGemStone = new ProductGemStone(params)

        assert productGemStone.save() != null
        assert ProductGemStone.count() == 1

        params.id = productGemStone.id

        controller.delete()

        assert ProductGemStone.count() == 0
        assert ProductGemStone.get(productGemStone.id) == null
        assert response.redirectedUrl == '/productGemStone/list'
    }
}
